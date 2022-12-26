$('#tabel-pesanan').DataTable({
  ajax: {
    url: '/api/pesanan',
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
      data: null,
      render: function (data, type, row, meta) {
        return `<button
                  type="button"
                  class="btn btn-info"
                  data-bs-toggle="modal"
                  data-bs-target="#detailPesanan" 
                  onclick="findById(${data.id})">
                  <i class="bi bi-info-circle"></i>
                  </button>
                  <button
                  type="button"
                  class="btn btn-primary"
                  onclick="approvePesanan(${data.id})">
                  <i class="bi bi-check-lg"></i> Approve
                  </button>
                  <button
                  type="button"
                  class="btn btn-danger"
                  onclick="disapprovePesanan(${data.id})">
                  <i class="bi bi-x-lg"></i> Disapprove
                  </button>`;
      },
    },
  ],
});

function findById(id) {
  $.ajax({
    method: 'GET',
    url: 'api/pesanan/' + id,
    dataType: 'json',
    success: (result) => {
      $('#pesanan-id').text(`${result.id}`);
      $('#pesanan-nama').text(`${result.nama}`);
      $('#pesanan-email').text(`${result.email}`);
      $('#pesanan-alamat').text(`${result.alamat}`);
      $('#pesanan-produk').text(`${result.produk.nama}`);
      $('#pesanan-jumlah').text(`${result.jumlah}`);
      $('#pesanan-pengguna').text(`${result.pengguna.nama}`);
    },
  });
}

function create() {
  let namaVal = $('#input-nama').val();
  console.log(namaVal);
  let emailVal = $('#input-email').val();
  console.log(emailVal);
  let alamatVal = $('#input-alamat').val();
  console.log(alamatVal);
  let produkVal = $('#input-produk').val();
  console.log(produkVal);
  let jumlahVal = $('#input-jumlah').val();
  console.log(jumlahVal);
  let penggunaVal = $('#input-pengguna').val();
  console.log(penggunaVal);

  $.ajax({
    method: 'POST',
    url: 'api/pesanan',
    dataType: 'json',
    contentType: 'application/json',
    data: JSON.stringify({
      nama: namaVal,
      email: emailVal,
      alamat: alamatVal,
      produk: { id: produkVal },
      jumlah: jumlahVal,
      pengguna: { id: penggunaVal },
    }),
    beforeSend: addCsrfToken(),
    success: (result) => {
      $('#createpesanan').modal('hide');
      $('#tabel-pesanan').DataTable().ajax.reload();
      $('#input-nama').val('');
      $('#input-email').val('');
      $('#input-alamat').val('');
      $('#input-produk').val('');
      $('#input-jumlah').val('');
      $('#input-pengguna').val('');
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Pesanan berhasil ditambahkan',
        showConfirmButton: false,
        timer: 1500,
      });
    },
  });
}

function approvePesanan(id) {
  Swal.fire({
    title: 'Apakah anda yakin?',
    text: 'Anda akan menyetujui pesanan ini!',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Ya, Setuju!',
  }).then((result) => {
    if (result.isConfirmed) {
      $.ajax({
        method: 'GET',
        url: 'api/pesanan/' + id,
        dataType: 'json',
        success: (result) => {
          $('#pesanan-id').text(`${result.id}`);
          $('#pesanan-nama').text(`${result.nama}`);
          Swal.fire({
            icon: 'success',
            title: 'Pesanan telah disetujui.',
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

function disapprovePesanan(id) {
  Swal.fire({
    title: 'Apakah anda yakin?',
    text: 'Anda akan menolak pesanan ini!',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Ya, Tolak!',
  }).then((result) => {
    if (result.isConfirmed) {
      $.ajax({
        method: 'DELETE',
        url: 'api/pesanan/' + id,
        dataType: 'json',
        beforeSend: addCsrfToken(),
        success: () => {
          $('#tabel-pesanan').DataTable().ajax.reload();
          Swal.fire({
            icon: 'success',
            title: 'Pesanan telah ditolak.',
            width: 600,
            padding: '3em',
            color: '#716add',
            showConfirmButton: false,
            timer: 1500,
          });
        },
      });
    }
  });
}
