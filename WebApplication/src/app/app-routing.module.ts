import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ResultLabComponent} from './result-lab/result-lab.component'
const routes: Routes = [
  {path:'labseq', component: ResultLabComponent},
  {path:'labseq/:n', component: ResultLabComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
