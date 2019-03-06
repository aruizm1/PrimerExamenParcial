import { Tag } from './tag.model';
export class User {
    constructor(
        public id: number,
        public nickname: string,
        public status: number,
        public tags: Tag[]
        ) { }
}
