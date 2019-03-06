import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Tag } from '../../models/tag.model';
import {Router} from '@angular/router';
import { TagsService } from '../../services/tags.service';
import { LocalStorage } from '@ngx-pwa/local-storage';


@Component({
  selector: 'app-tags',
  templateUrl: './tags.component.html',
  styleUrls: ['./tags.component.css']
})
export class TagsComponent implements OnInit {
@Output() dataTags = new EventEmitter<Tag[]>();
@Input() tag: Tag[];
value: string;
tagTemp: Tag;
temp1: Tag[];
temp: string;
exist: boolean = true;
empty: boolean = true;

  constructor(
    private router: Router,
    private tagsService: TagsService,
    protected localStorage: LocalStorage) { }

  ngOnInit() {
  }

  removeTag(index: number){
    this.tag.splice(index, 1);
    this.localStorage.setItem('tagsUser', this.tag).subscribe(() => {});

  }

  addTag() {
    if(this.tag !== null){
    this.temp = this.stdText(this.value);

    this.tagsService.getTags().subscribe( data => {



      if(data !== null){

        this.temp1 = data;

        for ( let item of this.temp1) {
          item.name = this.stdText(item.name);

          if (item.name.localeCompare(this.temp) === 0){
            this.exist = false;
            this.value = '';
            break;
          } else {
            this.exist = true;
            this.tagTemp = new Tag(null, this.value, true) ;
          }
        }

        if (this.exist){
        this.tag.push(this.tagTemp);
        this.dataTags.emit(this.tag);
        this.value = '';
        }
      }
      this.localStorage.setItem('tagsUser', data).subscribe(() => {});
    });
  }
  }


  stdText(texto) {

    texto = texto.toLowerCase();
    texto = texto.normalize('NFD').replace(/[\u0300-\u036f]/g,"");
    return texto;
  }
}
