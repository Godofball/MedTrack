function loginApi(data) {
  return $axios({
    'url': '/admin/login',
    'method': 'post',
    data
  })
}

function logoutApi(){
  return $axios({
    'url': '/admin/logout',
    'method': 'post',
  })
}
