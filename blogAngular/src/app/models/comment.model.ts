import { User } from './user.model';
export class Comment{
    constructor(
        public id: number,
        public  comment: string,
        public timestamp: Date,
        public status: boolean,
        public user: User
        ) { }
}
