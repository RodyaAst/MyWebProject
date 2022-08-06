import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PersonEntry} from "../Entries/PersonEntry";

@Injectable({providedIn: 'root'})
export class PersonService {

  private URL_BASE:string = "http://localhost:8080/person";

  constructor(private $http: HttpClient) {
  }

  public getPersons(): Observable<PersonEntry[]> {
    return this.$http.get<PersonEntry[]>(this.URL_BASE + "/person");
  }
}
