import {Visit} from "./visit";
import {User} from "./user";
import {Doctor} from "./doctor";

export class Patient {
  id: number;
  visits: Visit[];
  user: User;
  doctor: Doctor;
}
