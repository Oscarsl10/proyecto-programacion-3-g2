import { Component } from '@angular/core';
import { MarcasDeportivasc } from '../../marcas_deportivas/marcas-deportivasc';
import { ActivatedRoute, Router } from '@angular/router';
import { NikeService } from '../nike.service';
import { FormsModule } from '@angular/forms';
import { NikeComponent } from '../nike.component';
import { CommonModule } from '@angular/common';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-form-nike',
  standalone: true,
  imports: [NikeComponent, FormsModule, CommonModule],
  templateUrl: './form-nike.component.html'
})
export class FormNikeComponent {
  public nike: MarcasDeportivasc = new MarcasDeportivasc()
  titulo: string= "Formulario de marca Nike"

  constructor(private nikeService: NikeService, private router: Router,
    private activatedRouted: ActivatedRoute
  ){}
  
  ngOnInit(){
    this.cargarNikee()
  }

  //cargar la nike actual
  cargarNikee(): void{
    this.activatedRouted.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.nikeService.getNikee(id).subscribe( (nike) => this.nike = nike)
      }
    })
  }
  //Actualizar nike
  update():void{
    this.nikeService.update(this.nike).subscribe(nike=> {
      this.router.navigate(['/nike'])
      Swal.fire('Nike Actualizada', `Nike: ${nike.nombre} Actualizada con éxito!`, 'success')
    })
  }

  public create():void{
    //console.log("clicked");
    console.log(this.nike);
  
     this.nikeService.create(this.nike).subscribe(nike => 
      {this.router.navigate(["/nike"])
        Swal.fire('Nuevo nike', `Nike: ${nike.nombre} creado con éxito`, 'success')
      }
    );
  }
}