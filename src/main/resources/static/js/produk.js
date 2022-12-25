$('#tabel-produk').DataTable({
  ajax: {
    url: '/api/produk',
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
      data: 'gambar',
    },
    {
      data: 'harga',
    },
    {
      data: null,
      render: function (data, type, row, meta) {
        return `<button
                type="button"
                class="btn btn-primary"
                data-bs-toggle="modal"
                data-bs-target="#detailProduk" 
                onclick="findById(${data.id})">
                <i class="bi bi-info-circle"></i> Detail
                </button>
                <button 
                type="button" 
                class="btn btn-warning" 
                data-bs-toggle="modal"
                data-bs-target="#updateProduk" 
                onclick="beforeUpdate(${data.id})">
                <i class="bi bi-pencil"></i> Edit
                </button>
                <button 
                class="btn btn-danger" 
                onclick="deleteProduk(${data.id})">
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
    url: 'api/produk/' + id,
    dataType: 'json',
    success: (result) => {
      $('#produk-id').text(`${result.id}`);
      $('#produk-nama').text(`${result.nama}`);
      $('#produk-gambar').text(`${result.gambar}`);
      $('#produk-harga').text(`${result.harga}`);
      $('#produk-kategori').text(`${result.kategori.nama}`);
    },
  });
}

function create() {
  let namaVal = $('#input-nama').val();
  console.log(namaVal);
  let gambarVal = $('#input-gambar').val();
  console.log(gambarVal);
  let hargaVal = $('#input-harga').val();
  console.log(hargaVal);
  let kategoriVal = $('#input-kategori').val();
  console.log(kategoriVal);

  $.ajax({
    method: 'POST',
    url: 'api/produk',
    dataType: 'json',
    contentType: 'application/json',
    data: JSON.stringify({
      nama: namaVal,
      gambar: gambarVal,
      harga: hargaVal,
      kategori: { id: kategoriVal },
    }),
     beforeSend: addCsrfToken(),
    success: (result) => {
      $('#createproduk').modal('hide');
      $('#tabel-produk').DataTable().ajax.reload();
      $('#input-nama').val('');
      $('#input-gambar').val('');
      $('#input-harga').val('');
      $('#input-kategori').val('');
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Produk berhasil ditambahkan',
        showConfirmButton: false,
        timer: 1500,
      });
    },
  });
}

function beforeUpdate(id) {
  $.ajax({
    method: 'GET',
    url: 'api/produk/' + id,
    dataType: 'json',
    success: (result) => {
      $('#update-id').val(`${result.id}`);
      $('#update-nama').val(`${result.nama}`);
      $('#update-gambar').val(`${result.gambar}`);
      $('#update-harga').val(`${result.harga}`);
      $('#update-kategori').val(`${result.kategori.id}`);
    },
  });
}

function update() {
  let idVal = $('#update-id').val();
  let namaVal = $('#update-nama').val();
  let gambarVal = $('#update-gambar').val();
  let hargaVal = $('#update-harga').val();
  let kategoriVal = $('#update-kategori').val();

  console.log(idVal);
  console.log(namaVal);
  console.log(gambarVal);
  console.log(hargaVal);
  console.log(kategoriVal);

  $('#updateProduk').modal('hide');

  Swal.fire({
    title: 'Apakah anda yakin?',
    text: 'Anda akan mengubah produk!',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Yes',
  }).then((result) => {
    if (result.isConfirmed) {
      $.ajax({
        method: 'PUT',
        url: 'api/produk/' + idVal,
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify({
          nama: namaVal,
          gambar: gambarVal,
          harga: hargaVal,
          kategori: { id: kategoriVal },
        }),
         beforeSend: addCsrfToken(),
        success: (result) => {
          $('#table-region').DataTable().ajax.reload();
          $('#update-nama').val('');
          $('#update-gambar').val('');
          $('#update-harga').val('');
          $('#update-kategori').val('');
          Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Produk berhasil diupdate',
            showConfirmButton: false,
            timer: 1500,
          });
        },
      });
    }
  });
}

function deleteProduk(id) {
  Swal.fire({
    title: 'Apakah anda yakin?',
    text: 'Anda akan menghapus produk!',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Yes, delete it!',
  }).then((result) => {
    if (result.isConfirmed) {
      $.ajax({
        method: 'DELETE',
        url: 'api/produk/' + id,
        dataType: 'json',
         beforeSend: addCsrfToken(),
        success: () => {
          $('#tabel-produk').DataTable().ajax.reload();
          Swal.fire({
            icon: 'success',
            title: 'Produk berhasil dihapus.',
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
