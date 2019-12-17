import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Book} from '../../models/book';
import {BookRepository} from '../../services/book.repository';

@Component({
  selector: 'ngu-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.scss']
})
export class LibraryComponent implements OnInit {
  library: Observable<Book[]>;

  constructor(
    private bookService: BookRepository
  ) { }

  ngOnInit() {
    this.library = this.bookService.all();
  }

}
