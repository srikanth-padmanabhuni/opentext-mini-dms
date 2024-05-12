import { Component, OnInit } from '@angular/core';
import { Validators } from '@angular/forms';
import { FormArray } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { CommonServiceService } from '../../services/common-service.service';
import { OnChanges } from '@angular/core';

@Component({
  selector: 'app-meta-data',
  templateUrl: './meta-data.component.html',
  styleUrls: ['./meta-data.component.css']
})
export class MetaDataComponent implements OnInit, OnChanges {

  selectedFile: boolean

  form: FormGroup; 

  constructor(private fb: FormBuilder, private service: CommonServiceService) { 
    this.form = this.fb.group({
      metaData: this.fb.array([])
    })
  }

  ngOnInit() {
    this.isSelected();
  }

  ngOnChanges() {
    this.isSelected();
  }

  isSelected() {
    this.service.getFile().subscribe((f: any) => {
      if(f) {
        this.selectedFile = true;
      }
    })
  }

  get metaData() {
    return this.form.controls['metaData'] as FormArray;
  }

  addMetaData() {
    this.metaData.push(this.fb.group({
      title: ["", Validators.required],
      type: ['text', Validators.required]
    }));
  }

  deleteMetaData(index: number) {
    this.metaData.removeAt(index);
  }

  save() {
    console.log(this.form.value);
    this.service.saveMetaData(this.form.value);
  }

}