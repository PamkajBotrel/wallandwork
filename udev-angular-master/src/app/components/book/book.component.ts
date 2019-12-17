import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {Book} from '../../models/book';
import {BookRepository} from '../../services/book.repository';

@Component({
  selector: 'ngu-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent implements OnInit {
  book: Observable<Book>;

  constructor(
    private route: ActivatedRoute,
    private bookService: BookRepository
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.book = this.bookService.byId(params.get('id'));
    });
  }

}
