import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from './book';

@Injectable({
  providedIn: 'root'
})
export class BookServiceService {
  private booksUrl: string;
  private ids: Number[];

  constructor(private http: HttpClient) {
    this.booksUrl = 'http://localhost:8080/books';
  }

  public findAll(): Observable<Book[]> {
    return this.http.get<Book[]>(this.booksUrl);
  }

  public find(id: Number): Observable<Book> {
    return this.http.get<Book>(this.booksUrl, id);
  }

  public save(book: Book) {
    return this.http.post<Book>(this.booksUrl, book);
  }

  public delete(id: Number) {
    ids = id;
    return this.http.delete(this.booksUrl, this.ids);
  }


}
