import {User} from "./user";
import {Patient} from "./patient";

export class Doctor {
  id: number;
  user: User;
  patients: Patient[];
}
