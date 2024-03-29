import {HttpClient} from "@angular/common/http";
import {UserEntry} from "../user/UserEntry";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";

@Injectable({providedIn: 'root'})
export class UserService {

  private URL_BASE:string = "http://localhost:8080/user";



  constructor(private $http: HttpClient) {
  }

  public addUser(user: UserEntry):Observable<string> {
    return this.$http.post<string>(this.URL_BASE + "/add", user)
  }

  public getUsers(): Observable<UserEntry[]> {
    return this.$http.get<UserEntry[]>(this.URL_BASE + "/users");
  }

  public getByFilters(firstName: String, lastName: String, birthDay: Date, currentFrom: String, user: UserEntry): Observable<UserEntry[]> {
    return this.$http.get<UserEntry[]>(this.URL_BASE + `/usersByFilters?firstName=${firstName}&lastName=${lastName}&birthday=${birthDay}&currentFrom=${currentFrom}`);
  }
}
