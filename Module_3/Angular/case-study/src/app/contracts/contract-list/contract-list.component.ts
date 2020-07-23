import { Contract } from './../../models/Contract';
import { Component, OnInit } from '@angular/core';
import { ContractsService } from '../../services/contracts.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.scss']
})
export class ContractListComponent implements OnInit {
  term : any;
  p : any;

  contractList : Contract[];

  constructor(
    public contractsService : ContractsService,
    private router : Router
  ) { }

  showCreateContract() {
    this.router.navigateByUrl('/contracts/create');
  }
  showEditForm(id : number) {
    this.router.navigate(['/contracts/edit',id]);
  }
  deleteContract (id : number) {
    this.contractsService.deleteContract(id).subscribe(()=>{
      this.contractList = this.contractList.filter(
        t => t.id !== id
      );
    })
  }

  ngOnInit() {
    this.contractsService.getAllContract().subscribe(data => {this.contractList = data})
  }

}
