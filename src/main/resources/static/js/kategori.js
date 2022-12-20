$('#tabel-kategori').DataTable({
  ajax: {
    url: '/api/kategori',
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
      data: null,
      render: function (data, type, row, meta) {
        return `<button
                type="button"
                class="btn btn-primary"
                data-bs-toggle="modal"
                data-bs-target="#detailKategori" 
                onclick="findById(${data.id})">
                <i class="bi bi-info-circle"></i> Detail
                </button>
                <button 
                type="button" 
                class="btn btn-warning" 
                data-bs-toggle="modal"
                data-bs-target="#updateKategori" 
                onclick="beforeUpdate(${data.id})">
                <i class="bi bi-pencil"></i> Edit
                </button>
                <button 
                class="btn btn-danger" 
                onclick="deleteKategori(${data.id})">
                <i class="bi bi-trash"></i> Delete
                </button>
                `;
      },
    },
  ],
});

function findById(id) {
  $.ajax({
    method: 'GET',
    url: 'api/kategori/' + id,
    dataType: 'json',
    success: (result) => {
      $('#kategori-id').text(`${result.id}`);
      $('#kategori-nama').text(`${result.nama}`);
    },
  });
}

function create() {
  let namaVal = $('#input-nama').val();
  console.log(namaVal);

  $.ajax({
    method: 'POST',
    url: 'api/kategori',
    dataType: 'json',
    contentType: 'application/json',
    data: JSON.stringify({
      nama: namaVal,
    }),
    beforeSend: addCsrfToken(),
    success: (result) => {
      $('#createkategori').modal('hide');
      $('#tabel-kategori').DataTable().ajax.reload();
      $('#input-nama').val('');
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Kategori berhasil ditambahkan',
        showConfirmButton: false,
        timer: 1500,
      });
    },
  });
}

function beforeUpdate(id) {
  $.ajax({
    method: 'GET',
    url: 'api/kategori/' + id,
    dataType: 'json',
    success: (result) => {
      $('#update-id').val(`${result.id}`);
      $('#update-nama').val(`${result.nama}`);
    },
  });
}

function update() {
  let namaVal = $('#update-nama').val();
  let idVal = $('#update-id').val();

  console.log(namaVal);
  console.log(idVal);

  $('#updateKategori').modal('hide');

  Swal.fire({
    title: 'Apakah anda yakin?',
    text: 'Anda akan mengubah kategori!',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Yes',
  }).then((result) => {
    if (result.isConfirmed) {
      $.ajax({
        method: 'PUT',
        url: 'api/kategori/' + idVal,
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify({
          nama: namaVal,
        }),
        beforeSend: addCsrfToken(),
        success: (result) => {
          $('#table-region').DataTable().ajax.reload();
          $('#update-nama').val('');
          Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Kategori berhasil diupdate',
            showConfirmButton: false,
            timer: 1500,
          });
        },
      });
    }
  });
}

function deleteKategori(id) {
  Swal.fire({
    title: 'Apakah anda yakin?',
    text: 'Anda akan menghapus kategori!',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Yes, delete it!',
  }).then((result) => {
    if (result.isConfirmed) {
      $.ajax({
        method: 'DELETE',
        url: 'api/kategori/' + id,
        dataType: 'json',
        beforeSend: addCsrfToken(),
        success: () => {
          $('#tabel-kategori').DataTable().ajax.reload();
          Swal.fire({
            icon: 'success',
            title: 'Kategori berhasil dihapus.',
            width: 600,
            padding: '3em',
            color: '#716add',
            backdrop: `rgba(0,0,123,0.4) 
            url("https://sweetalert2.github.io/images/nyan-cat.gif") 
            left top no-repeat`,
            showConfirmButton: false,
            timer: 1500,
          });
        },
      });
    }
  });
}
