import { User } from './user.model';
export class Enjoy{
    constructor(
    public id: number,
    public status: boolean,
    public user: User
    ){}
}