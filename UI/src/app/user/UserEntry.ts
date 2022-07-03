import {JobEntry} from "../Entries/JobEntry";

export interface UserEntry {
  id?: number;
  firstName?: string;
  lastName?: number;
  birthdate?: Date;
  currentFrom?: string;
  job?: JobEntry;
}
