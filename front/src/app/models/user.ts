import {Patient} from "./patient";

export class User {
  id: number;
  username: string;
  password: string;
  pesel: string;
  name: string;
  surname: string;
  dateOfBirth: Date;
  patient: Patient;
}
