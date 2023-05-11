import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { catchError, map, of, switchMap } from 'rxjs';

interface Child {
  id: number;
  sender: string;
  receiver: string;
  totalAmount: number;
  totalPaidAmount: number;
}

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.scss'],
  standalone: true,
  imports: [
    MatTableModule, MatCardModule, RouterModule,
    CommonModule, MatIconModule, MatButtonModule
  ]
})
export class ChildComponent {
  displayedColumns: string[] = ['id', 'sender', 'receiver', 'totalAmount', 'totalPaidAmount'];
  pageSizeOptions = Array.from({ length: 5 }).map((_, index) => index + 1);

  httpClient = inject(HttpClient);
  activatedRoute = inject(ActivatedRoute)
  dataSource$ = this.activatedRoute.params.pipe(
    switchMap(({ parentId }) => this.httpClient.get<Child[]>(`/api/child/${parentId}`)
      .pipe(map(response => ({
        data: response,
        error: null
      })))
    ),
    catchError((err: HttpErrorResponse) => of({
      data: null,
      error: err.error.message
    })),
  );
}
