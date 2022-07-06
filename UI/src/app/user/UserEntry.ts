import {JobEntry} from "../Entries/JobEntry";

export interface UserEntry {
  id?: Number;
  firstName?: String;
  lastName?: Number;
  birthdate?: Date;
  currentFrom?: String;
  job?: JobEntry;
}
