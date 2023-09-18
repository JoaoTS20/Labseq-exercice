import { Component, OnInit } from '@angular/core';
import { ResultLabseqService } from '../resultLabseq.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router'

@Component({
  selector: 'app-result-lab',
  templateUrl: './result-lab.component.html',
  styleUrls: ['./result-lab.component.css']
})
export class ResultLabComponent implements OnInit {

  currentResult: number=0;
  currentSearch:number=0;

  constructor(private route: ActivatedRoute,private router: Router,private resultLabSeqService: ResultLabseqService) { }

  ngOnInit(): void {
    this.currentSearch=Number(this.route.snapshot.paramMap.get('n'));
    console.log(this.currentSearch)
    this.getResultLabSeq(this.currentSearch)
  }

  getResultLabSeq(n:number){
    this.resultLabSeqService.getResultLabSeq(n).subscribe(
      data => {
        console.log(data);
        this.router.navigateByUrl('/labseq/'+n);
        this.currentResult=data;
        this.currentSearch=n;
      },
      error=>console.log(error));
    
  }
  
}
