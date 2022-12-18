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
  ],
});
