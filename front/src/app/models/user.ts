import {Patient} from "./patient";
import { Doctor } from './doctor';

export class User {
  id: number;
  username: string;
  password: string;
  pesel: string;
  name: string;
  surname: string;
  dateOfBirth: Date;
  patient: Patient;
  doctor: Doctor;
}
