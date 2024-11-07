import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AdidasComponent } from './adidas/adidas.component';
import { NikeComponent } from './nike/nike.component';
import { PumaComponent } from './puma/puma.component';
import { FormAdidasComponent } from './adidas/adidasForm/form-adidas.component';
import { FormNikeComponent } from './nike/nikeForm/form-nike.component';
import { FormPumaComponent } from './puma/pumaForm/form-puma.component';
import { MarcasDeportivasComponent } from './marcas_deportivas/marcas-deportivas.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, FooterComponent, AdidasComponent, NikeComponent, PumaComponent, 
    FormAdidasComponent, FormNikeComponent, FormPumaComponent, MarcasDeportivasComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'proyectomarcasd';
}