import { Component } from '@angular/core';
import { MarcasDeportivasc } from '../../marcas_deportivas/marcas-deportivasc';
import { ActivatedRoute, Router } from '@angular/router';
import { PumaService } from '../puma.service';
import { PumaComponent } from '../puma.component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-form-puma',
  standalone: true,
  imports: [PumaComponent, FormsModule, CommonModule],
  templateUrl: './form-puma.component.html'
})
export class FormPumaComponent {
  public puma: MarcasDeportivasc = new MarcasDeportivasc()
  titulo: string= "Formulario de marca Puma"

  constructor(private pumaService: PumaService, private router: Router,
    private activatedRouted: ActivatedRoute
  ){}
  
  ngOnInit(){
    this.cargarPumaa()
  }

  //cargar la puma actual
  cargarPumaa(): void{
    this.activatedRouted.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.pumaService.getPumaa(id).subscribe( (puma) => this.puma = puma)
      }
    })
  }
  //Actualizar puma
  update():void{
    this.pumaService.update(this.puma).subscribe(puma=> {
      this.router.navigate(['/puma'])
      Swal.fire('Puma Actualizada', `Puma: ${puma.nombre} Actualizada con éxito!`, 'success')
    })
  }

  public create():void{
    //console.log("clicked");
    console.log(this.puma);
  
     this.pumaService.create(this.puma).subscribe(puma => 
      {this.router.navigate(["/puma"])
        Swal.fire('Nuevo puma', `Puma: ${puma.nombre} creado con éxito`, 'success')
      }
    );
  }
}