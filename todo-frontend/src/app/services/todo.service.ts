import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { MatSnackBar } from "@angular/material/snack-bar";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Todo } from "../models/Todo";

@Injectable({
  providedIn: "root",
})
export class TodoService {
  baseUrl = environment.baseUrl;
  constructor(private httpClient: HttpClient, private snack: MatSnackBar) {}

  findAll(): Observable<Todo[]> {
    return this.httpClient.get<Todo[]>(this.baseUrl);
  }

  findById(id: any): Observable<Todo> {
    return this.httpClient.get<Todo>(`${this.baseUrl}/${id}`);
  }

  update(todo: Todo): Observable<Todo> {
    return this.httpClient.put<Todo>(`${this.baseUrl}/${todo.id}`, todo);
  }

  delete(id: any): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}/${id}`);
  }

  create(todo: Todo): Observable<Todo> {
    console.log(todo);
    return this.httpClient.post<Todo>(this.baseUrl, todo);
  }

  message(msg: string): void {
    this.snack.open(`${msg}`, "Ok", {
      horizontalPosition: "end",
      verticalPosition: "top",
      duration: 4000,
    });
  }
}
