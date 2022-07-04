import {Component, OnInit} from '@angular/core';
import {UserEntry} from "../../user/UserEntry";
import {HttpClient} from "@angular/common/http";
import {UserService} from "../../services/UserService";

@Component({
  selector: 'app-start-page',
  templateUrl: './start-page.component.html',
})
export class StartPageComponent implements OnInit {

  private BASE_URL: string = "http://localhost:8080/user";
  public user: UserEntry = {};
  public newUser: UserEntry = {};
  public userList: UserEntry[] = [];
  public number: number = 1;

  constructor(private http: HttpClient,
              private userService: UserService) {
    this.getUsers();
  }

  ngOnInit(): void {
  }

  public confirmForm(): void {
    this.userService.addUser(this.newUser)
      .subscribe(() => {
        this.getUsers();
      });
  }

  private getUsers() {
    this.userService.getUsers()
      .subscribe(result => this.userList = result)
  }
}
