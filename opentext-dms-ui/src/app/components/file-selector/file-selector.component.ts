import { Component, OnInit } from '@angular/core';
import { CommonServiceService } from '../../services/common-service.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-file-selector',
  templateUrl: './file-selector.component.html',
  styleUrls: ['./file-selector.component.css']
})
export class FileSelectorComponent implements OnInit {

  files: any[];

  constructor(private service: CommonServiceService, private sanitizer: DomSanitizer) {}

  ngOnInit() {}

  onFileChange(event) {
    const files = event.target.files;
    if(!this.files) {
      this.files = [];
    }

    for (const file of files) {
      this.files.push({
        name: file.name,
        content: file.content,
        file: file,
        fileUrl: this.sanitizer.bypassSecurityTrustResourceUrl(URL.createObjectURL(file))
      });
    }
    this.selectFile(this.files[0].fileUrl);
    console.log(this.files);
  }

  selectFile(file: any) {
    this.service.setFile(file);
  }
}