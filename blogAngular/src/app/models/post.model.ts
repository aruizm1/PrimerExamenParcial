import { Enjoy } from './enjoy.model';
import { Comment } from './comment.model';
import { Tag } from './tag.model';
import { User } from './user.model';

export class Post{
    constructor(
        public id: number,
        public title: string,
        public  text: string,
        public  imagen: string,
        public status: boolean,
        public timestamp: Date,
        public  enjoys: Enjoy,
        public user: User,
        public comments: Comment[],
        public tagsPost: Tag[]
    ){}
}