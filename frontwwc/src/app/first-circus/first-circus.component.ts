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
  users: User[] = [];
  myUserId:number;


  constructor(private circusService: CircusService, private userService: UserService, private router: Router) {
    this.listCircus = [];
   }

  ngOnInit() {
    this.circusService.getAllCircus().subscribe(
      (param: Circus[]) => {
        this.listCircus = param;
      }
    );

    this.userService.getAllUser().subscribe(
      (users: User[]) => {
      this.users = users;
    }
    );
  }

  choose(data:any) {
    this.users[0].money -= data.cost;
    this.users[0].circusId = data.id;
    this.myUserId = this.users[0].id;

    this.userService.updateUser(this.users[0].id, this.users[0]).subscribe(data => console.log('Done'), error => console.log(error));
    this.router.navigateByUrl('/dashboard');
  }



}
