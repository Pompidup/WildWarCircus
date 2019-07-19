import { Component, OnInit } from '@angular/core';
import { User } from '../class/user';
import { UserService } from '../services/user.service';
import { CircusService } from '../services/circus.service';
import { Circus } from '../class/circus';
import { ShowService } from '../services/show.service';
import { Show } from '../class/show';
import { Stand } from '../class/stand';
import { StandService } from '../services/stand.service';
import { CrasseService } from '../services/crasse.service';
import { PubService } from '../services/pub.service';
import { Pub } from '../class/pub';
import { Crasse } from '../class/crasse';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  users: User;
  myUser: User;
  myCircus: Circus;
  myStand: Stand[];
  myShow: Show[];
  allShow: Show[];
  allStand: Stand[];
  allPub: Pub[];
  allCrasse: Crasse[];
  circusId: number;
  showShow: boolean;
  showStand: boolean;
  showUpgrade: boolean;
  showPub: boolean;
  showCrasse: boolean;
  showLevel: boolean;

  week: number;


  depense: number = 0;
  gainStand: number = 0;
  nbVisiteur: number = 100;
  myVisitor: number = 0;

  constructor(private userService: UserService, private circusService: CircusService, private showService: ShowService, private standService: StandService, private crasseService: CrasseService, private pubService: PubService) {
    this.showShow = false;
    this.showStand = false;
    this.showUpgrade = false;
    this.showPub = false;
    this.showCrasse = false;
    this.week = 0;
    this.myStand = [];
    this.myShow = [];

  }


  ngOnInit() {

    this.userService.getOneUser(localStorage.getItem('username')).subscribe(
      (user: User) => {
        this.myUser = user;
        this.afterInit();
      }
    );

    this.showService.getAllShow().subscribe(
      (data: Show[]) => {
        this.allShow = data;
      }
    );

    this.standService.getAllStand().subscribe(
      (data: Stand[]) => {
        this.allStand = data;
      }
    );

    this.crasseService.getAllCrasse().subscribe(
      (data: Crasse[]) => {
        this.allCrasse = data;
      }
    );

    this.pubService.getAllPub().subscribe(
      (data: Pub[]) => {
        this.allPub = data;
      }
    );
  }

  afterInit() {
    this.circusService.getOne(this.myUser.circusId).subscribe(
      (data: Circus) => {
        this.myCircus = data;
      }
    );
  }

  addShow() {
    this.showShow = !this.showShow;
  }

  buyShow(data: Show) {
    if (data.cost <= this.myUser.money && this.myCircus.nbShow < this.myCircus.nbShowMax) {
      this.myUser.money -= data.cost;
      this.myCircus.nbShow++;
      this.myCircus.popularity += data.popUp;
      data.circusId = this.myCircus.id;
      this.myShow.push(data);
      this.showService.updateShow(data.id, data).subscribe(data => console.log('Done'), error => console.log(error));
      this.circusService.updateCircus(this.myCircus.id, this.myCircus).subscribe(data => console.log('Done'), error => console.log(error));
    } else {
      alert('Achat Impossible');
    }

  }

  addStand() {
    this.showStand = !this.showStand;
  }

  buyStand(data: Stand) {
    if (data.cost <= this.myUser.money && this.myCircus.nbStand < this.myCircus.nbStandMax) {
      this.myUser.money -= data.cost;
      this.myCircus.nbStand++;
      data.circusId = this.myCircus.id;
      this.myStand.push(data);
      this.standService.updateStand(data.id, data).subscribe(data => console.log('Done'), error => console.log(error));
      this.circusService.updateCircus(this.myCircus.id, this.myCircus).subscribe(data => console.log('Done'), error => console.log(error));
    } else {
      alert('Achat Impossible');
    }
  }

  addCrasse() {
    this.showCrasse = !this.showCrasse;
  }

  buyCrasse(data: Crasse) {

    alert('WIP');
  }

  addPub() {
    this.showPub = !this.showPub;
  }

  buyPub(data: Pub) {
    if (data.cost <= this.myUser.money) {
      this.myUser.money -= data.cost;
      this.myCircus.popularity += data.popUp;
    } else {
      alert('On fait pas crédit ici !!');
    }

  }

  launch() {
    this.depense = 0;
    this.gainStand = 0;
    this.myVisitor = Math.round((this.nbVisiteur * this.myCircus.popularity)/100);
    if (this.myShow.length > 0) {
      for (let i: number = 0 ; i < this.myShow.length; i++) {
        this.depense += this.myShow[i].maintenance
      }
    }
    if (this.myStand.length > 0) {
      for (let i: number = 0; i < this.myStand.length; i++) {
        this.depense += this.myStand[i].maintenance;
        this.gainStand += (this.myStand[i].gain*((this.myVisitor * this.myStand[i].convertion)/100))*10;
      }
    }
    let tot: number = this.gainStand - this.depense + (this.myCircus.price * this.myVisitor);
    this.myUser.money += Math.round(tot);
    this.week++;
    this.nbVisiteur += Math.round((this.nbVisiteur*10)/100);
    this.userService.updateUser(this.myUser.id, this.myUser).subscribe(data => console.log('Done'), error => console.log(error));
  }

  upLevel() {
    alert('WIP');
  }

}
