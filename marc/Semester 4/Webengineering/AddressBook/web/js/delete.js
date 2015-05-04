/**
 * Created by Marc on 30.04.2015.
 */

$(function(){
    $('button[data-delete]').click(function(){
        var id = $(this).data('id');
        var redirect = $(this).data('redirect');

        swal({
            title: 'Sind Sie sicher?',
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#DD6B55',
            confirmButtonText: 'Löschen',
            cancelButtonText: 'Abbrechen',
            closeOnConfirm: true
        }, function(){
            $.get('/delete?id=' + id, function(){
                if(redirect === 'reload'){
                    location.reload();
                }else{
                    location.href = redirect;
                }
            });
        });
    });
});