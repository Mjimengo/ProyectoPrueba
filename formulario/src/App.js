import React, { useState } from 'react';


const FormularioRegistro = () => {
  const [formData, setFormData] = useState({
    nombre: '',
    apellido: '',
    telefono: '',
    password: '',
  });
  const [registroExitoso, setRegistroExitoso] = useState(false);
  const [botonDesactivado, setBotonDesactivado] = useState(false);

  const handleChange = (event) => {
    setFormData({
      ...formData,
      [event.target.name]: event.target.value,
    });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    if (botonDesactivado) return; 

    setBotonDesactivado(true); 

    let url = "http://localhost:8080/api/cliente/create";
    try {
      const response = await fetch(url, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(formData),
      });
      
      if (response.ok) {
        setRegistroExitoso(true);
      }
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div className='cliente'>
      <div className='container'>
        <div className="mt-5 d-flex flex-column mb-2">
          <div className='w-100 titulo-cliente'>
            <h1>Formulario Cliente</h1>
          </div>
          <div className='contenedor-cliente'>
            <div className='titulo-añadir mt-1'>
              <h2>Información<br/> Necesaria</h2>
            </div>
            {registroExitoso && (
              <div className="alert alert-success" role="alert">
                Te has registrado correctamente.
              </div>
            )}
            <form className='controls-cliente' onSubmit={handleSubmit}>
              <div className='d-flex flex-column gap-1'>
                <label htmlFor="nombre">Nombre</label>
                <input
                  type="text"
                  placeholder='Nombre'
                  required={true}
                  className="form-control"
                  name='nombre'
                  onChange={handleChange}
                />
              </div><br />
              <div className='d-flex flex-column gap-1'>
                <label htmlFor="apellido">Apellidos</label>
                <input
                  type="text"
                  placeholder='Apellidos'
                  required={true}
                  className="form-control"
                  name='apellido'
                  onChange={handleChange}
                />
              </div><br />
              <div className='d-flex flex-column gap-1'>
                <label htmlFor="telefono">Teléfono</label>
                <input
                  type="text"
                  placeholder='Teléfono'
                  required={true}
                  className="form-control"
                  name='telefono'
                  onChange={handleChange}
                />
              </div><br />
              <div className='d-flex flex-column gap-1'>
                <label htmlFor="email">Email</label>
                <input
                  type="text"
                  placeholder='Email'
                  required={true}
                  className="form-control"
                  name='email'
                  onChange={handleChange}
                />
              </div><br />
              <div className='d-flex flex-column gap-1'>
                <label htmlFor="password">Contraseña</label>
                <input
                  type="password"
                  placeholder='Contraseña'
                  required={true}
                  className="form-control"
                  name='password'
                  onChange={handleChange}
                />
              </div><br />
              <div className='botonmascliente'>
                <button>Añadir</button>
              </div>
            </form>
            <div className='botonatrascliente'>
                <button>Atrás</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default FormularioRegistro

