import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, inject, ChangeDetectionStrategy } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatPaginatorModule, PageEvent } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { RouterModule } from '@angular/router';
import { BehaviorSubject, switchMap } from 'rxjs';

interface Parent {
  id: number;
  sender: string;
  receiver: string;
  totalAmount: number;
  totalPaidAmount: number;
}

interface Paging {
  data: Parent[];
  total: number;
}

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.scss'],
  standalone: true,
  imports: [MatTableModule, MatCardModule, HttpClientModule, CommonModule, RouterModule, MatPaginatorModule],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ParentComponent {
  displayedColumns: string[] = ['id', 'sender', 'receiver', 'totalAmount', 'totalPaidAmount'];
  pageSizeOptions = Array.from({ length: 5 }).map((_, index) => index + 1);

  httpClient = inject(HttpClient);
  params = new BehaviorSubject({ page: 1, pageSize: 2 });
  dataSource$ = this.params.pipe(
    switchMap(params => this.httpClient.get<Paging>("/api/parent", { params })),
  );

  paginatorChange({ pageIndex, pageSize }: PageEvent) {
    this.params.next({ page: pageIndex + 1, pageSize });
  }

}
