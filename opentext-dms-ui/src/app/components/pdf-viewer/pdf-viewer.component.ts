import { Component, OnInit } from '@angular/core';
import { CommonServiceService } from '../../services/common-service.service';
import { OnChanges } from '@angular/core';

@Component({
  selector: 'app-pdf-viewer',
  templateUrl: './pdf-viewer.component.html',
  styleUrls: ['./pdf-viewer.component.css']
})
export class PdfViewerComponent implements OnInit, OnChanges {

  file: any;

  constructor(private service: CommonServiceService) { }

  ngOnInit() {
    this.getFile();
  }

  ngOnChanges() {
    this.getFile();
  }

  getFile() {
    this.service.getFile().subscribe((f: any) => {
      this.file = f;
    })
  }

}