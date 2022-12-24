function create() {
  let namaVal = $('#input-nama').val();
  console.log(namaVal);
  let emailVal = $('#input-email').val();
  console.log(emailVal);
  let alamatVal = $('#input-alamat').val();
  console.log(alamatVal);
  // let penggunaVal = $('#input-pengguna').val();
  // console.log(penggunaVal);

  $.ajax({
    method: 'POST',
    url: 'api/pesanan',
    dataType: 'json',
    contentType: 'application/json',
    data: JSON.stringify({
      nama: namaVal,
      email: emailVal,
      alamat: alamatVal,
      // pengguna: { id: penggunaVal },
    }),
    beforeSend: addCsrfToken(),
    success: (result) => {
      $('#createpesanan').modal('hide');
      $('#tabel-pesanan').DataTable().ajax.reload();
      $('#input-nama').val('');
      $('#input-email').val('');
      $('#input-alamat').val('');
      // $('#input-pengguna').val('');
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
