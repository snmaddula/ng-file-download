import { Component, OnInit } from '@angular/core';
import { FileDownloadService } from '../../service/file-download.service';
import { saveAs } from 'file-saver';

const MIME_TYPES = {
  xls  : 'application/vnd.ms-excel',
  xlsx : 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'
};


@Component({
  selector: 'app-file-download',
  templateUrl: './file-download.component.html',
  styleUrls: ['./file-download.component.css']
})
export class FileDownloadComponent implements OnInit {

  constructor(private service:FileDownloadService) { }

  ngOnInit() {
  }
  
  downloadFile(fileName) {
    console.log("fileName : " + fileName);
    const extension = fileName.substr(fileName.lastIndexOf('.') + 1)
    this.service.downloadFile({'fileName': fileName})
    .subscribe(data => {
      saveAs(new Blob([data], { type: MIME_TYPES[extension] }), fileName);
    })
  }

}
