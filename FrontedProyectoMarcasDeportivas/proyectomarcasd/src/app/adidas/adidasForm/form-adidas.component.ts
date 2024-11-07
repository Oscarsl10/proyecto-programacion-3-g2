import { Component } from '@angular/core';
import { MarcasDeportivasc } from '../../marcas_deportivas/marcas-deportivasc';
import { ActivatedRoute, Router } from '@angular/router';
import { AdidasService } from '../adidas.service';
import { AdidasComponent } from '../adidas.component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-form-adidas',
  standalone: true,
  imports: [FormsModule, AdidasComponent, CommonModule],
  templateUrl: './form-adidas.component.html'
})
export class FormAdidasComponent {
  public adidas: MarcasDeportivasc = new MarcasDeportivasc()
  titulo: string= "Formulario de marca Adicas"

  constructor(private adidasService: AdidasService, private router: Router,
    private activatedRouted: ActivatedRoute 
  ){}
  
  ngOnInit(){
    this.cargarAdida()
  }

  //cargar la adidas actual
  cargarAdida(): void{
    this.activatedRouted.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.adidasService.getAdida(id).subscribe( (adidas) => this.adidas = adidas)
      }
    })
  }
  //Actualizar adidas
  update():void{
    this.adidasService.update(this.adidas).subscribe(adidas=> {
      this.router.navigate(['/adidas'])
      Swal.fire('Adidas Actualizada', `Adidas: ${adidas.nombre} Actualizada con éxito!`, 'success')
    })
  }

  public create():void{
    //console.log("clicked");
    console.log(this.adidas);
  
     this.adidasService.create(this.adidas).subscribe(adidas => 
      {this.router.navigate(["/adidas"])
        Swal.fire('Nuevo adidas', `Tarea: ${adidas.nombre} creado con éxito`, 'success')
      }
    );
    }
}