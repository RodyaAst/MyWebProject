import {PersonBodyInfoEntry} from "../services/PersonBodyInfoEntry";

export interface PersonEntry {
  id?: Number;
  firstName?: String;
  lastName?: String;
  patronymic?: String;
  birthDate?: Date;
  currentLive?: String;
  passportNumber?: String;
  omsCode?: String;
  dmsCode?: String;
  snils?: String;
  job?: String;
  sex?: String;
  personBodyInfo?: PersonBodyInfoEntry;
}
