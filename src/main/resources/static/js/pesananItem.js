$('#tabel-pesananItem').DataTable({
  ajax: {
    url: '/api/pesananItem',
    dataSrc: '',
  },
  columns: [
    {
      data: 'id',
    },
    {
      data: 'pesanan',
    },
    {
      data: 'produk',
    },
    {
      data: 'kuantitas',
    },
    {
      data: 'harga',
    },
    {
      data: 'jumlah',
    },
  ],
});
