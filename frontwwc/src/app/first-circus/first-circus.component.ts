import { Component, OnInit } from '@angular/core';
import { Circus } from '../class/circus';
import { CircusService } from '../services/circus.service';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';
import { User } from '../class/user';

@Component({
  selector: 'app-first-circus',
  templateUrl: './first-circus.component.html',
  styleUrls: ['./first-circus.component.css']
})
export class FirstCircusComponent implements OnInit {

  listCircus: Circus[];
  myUser: User;
  allUser: User[];


  constructor(private circusService: CircusService, private userService: UserService, private router: Router) {
    this.listCircus = [];
    this.allUser = [];
    this.myUser = new User;
  }

  ngOnInit() {
    this.circusService.getAllCircus().subscribe(
      (param: Circus[]) => {
        this.listCircus = param;
      }
    );

    this.userService.getAllUser().subscribe(
      (user: User[]) => {
        this.allUser = user;
      }

    );


  };

  init() {
    for (let i: number = 0; i < this.allUser.length; i++) {
      if (this.allUser[i].username == localStorage.getItem('username')) {
        this.myUser = this.allUser[i];
      }
    }
  }

  choose(data: any) {

    if (this.myUser.money >= data.cost) {
      this.myUser.money -= data.cost;
      this.myUser.circusId = data.id;
      this.userService.updateUser(this.myUser.id, this.myUser).subscribe(data => console.log('Done'), error => console.log(error));
      this.router.navigateByUrl('/dashboard');
    } else {
      alert("Désolé t'as pas assez !!")
    }

  }



}
