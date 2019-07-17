import { Component, OnInit } from '@angular/core';
import { User } from '../class/user';
import { UserService } from '../services/user.service';
import { CircusService } from '../services/circus.service';
import { Circus } from '../class/circus';
import { ShowService } from '../services/show.service';
import { Show } from '../class/show';
import { Stand } from '../class/stand';
import { StandService } from '../services/stand.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  users: User[] = [];
  myUser: User;
  myCircus: Circus;
  allShow: Show[];
  allStand: Stand[];
  circusId: number;
  showShow: boolean;
  showStand: boolean;
  showUpgrade: boolean;

  depense:number = 0;
  gainStand:number = 0;
  nbVisiteur:number = 100;

  constructor(private userService: UserService, private circusService: CircusService, private showService: ShowService, private standService: StandService) {
    this.showShow = false;
    this.showStand = false;
    this.showUpgrade = false;
  }

  ngOnInit() {
    this.userService.getAllUser().subscribe(
      (users: User[]) => {
        this.users = users;
        this.myUser = this.users[0];
        this.circusId = this.myUser.circusId;
      }
    );

    this.circusService.getOne(1).subscribe(
      (data: Circus) => {
        this.myCircus = data;
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
  }

  addShow(){
    this.showShow = !this.showShow;
  }

  buyShow(data:Show){
    console.log(data.id);
    if(data.cost <= this.myUser.money && this.myCircus.nbShow < this.myCircus.nbShowMax){
      this.myUser.money -= data.cost;
      this.myCircus.nbShow ++;
      this.myCircus.popularity += data.popUp;
      this.depense += data.maintenance;
    } else {
      alert('Achat Impossible');
    }

  }

  addStand() {
    this.showStand = !this.showStand;
  }

  buyStand(data:Stand){
    if(data.cost <= this.myUser.money && this.myCircus.nbStand < this.myCircus.nbStandMax){
      this.myUser.money -= data.cost;
      this.myCircus.nbStand ++;
      this.depense += data.maintenance;
      this.gainStand += data.gain;
    } else {
      alert('Achat Impossible');
    }
  }

}
