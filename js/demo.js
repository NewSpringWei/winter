function checkNumber(domId) {
  var value = $("#" + domId).val();
  value = value.replace(/[^\d]/g, "");
  value = value.substr(0, 8);
  value = Number(value);
  if (isNaN(value)) {
    value = 0;
  }
  $("#" + domId).val(value);
}