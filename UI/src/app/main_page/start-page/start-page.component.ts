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
  // @ts-ignore
  public userList: UserEntry[] = [];
  public number: Number = 1;
  public isDeleteJobLess: Boolean = false;
  // @ts-ignore
  public filter: any = {}
  // @ts-ignore
  public usersByFilters: UserEntry[];

  constructor(private http: HttpClient,
              private userService: UserService) {
    this.getEmptyFilters();
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


  public hideJobless() {

  }

  public getUsersByFilters(): void {
    // @ts-ignore
    this.userService.getByFilters(this.filter.firstName, this.filter.lastName,
      this.filter.birthday, this.filter.currentFrom)
      .subscribe(res => this.usersByFilters = res);
  }

  public getEmptyFilters() {
    this.filter.firstName = null;
    this.filter.lastName = null;
    this.filter.birthday = null;
    this.filter.currentFrom = null;
  }
}
