$('#tabel-pengguna').DataTable({
  ajax: {
    url: '/api/pengguna',
    dataSrc: '',
  },
  columns: [
    {
      data: 'id',
    },
    {
      data: 'nama',
    },
    {
      data: 'email',
    },
    {
      data: 'alamat',
    },
    {
      data: 'no_hp',
    },
    {
      data: null,
      render: function (data, type, row, meta) {
        return `
                <button 
                type="button" 
                class="btn btn-warning" 
                data-bs-toggle="modal"
                data-bs-target="#updatePengguna" 
                onclick="beforeUpdate(${data.id})">
                <i class="bi bi-pencil"></i> Edit
                </button>                
                `;
      },
    },
  ],
});

function beforeUpdate(id) {
  $.ajax({
    method: 'GET',
    url: 'api/pengguna/' + id,
    dataType: 'json',
    success: (result) => {
      $('#update-id').val(`${result.id}`);
      $('#update-nama').val(`${result.nama}`);
      $('#update-email').val(`${result.email}`);
      $('#update-alamat').val(`${result.alamat}`);
      $('#update-nohp').val(`${result.no_hp}`);
    },
  });
}

function update() {
  let idVal = $('#update-id').val();
  let namaVal = $('#update-nama').val();
  let emailVal = $('#update-email').val();
  let alamatVal = $('#update-alamat').val();
  let nohpVal = $('#update-nohp').val();

  console.log(idVal);
  console.log(namaVal);
  console.log(emailVal);
  console.log(alamatVal);
  console.log(nohpVal);

  $('#updatePengguna').modal('hide');

  Swal.fire({
    title: 'Apakah anda yakin?',
    text: 'Anda akan mengubah pengguna!',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Yes',
  }).then((result) => {
    if (result.isConfirmed) {
      $.ajax({
        method: 'PUT',
        url: 'api/pengguna/' + idVal,
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify({
          nama: namaVal,
          email: emailVal,
          alamat: alamatVal,
          no_hp: nohpVal,
        }),
        beforeSend: addCsrfToken(),
        success: (result) => {
          $('#tabel-pengguna').DataTable().ajax.reload();
          $('#update-nama').val('');
          $('#update-email').val('');
          $('#update-alamat').val('');
          $('#update-nohp').val('');
          Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Pengguna berhasil diupdate',
            showConfirmButton: false,
            timer: 1500,
          });
        },
      });
    }
  });
}
