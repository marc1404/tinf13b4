/**
 * Created by Marc on 30.04.2015.
 */

$(function(){
    $('button[data-delete]').click(function(){
        var that = this;

        swal({
            title: 'Are you sure?',
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#DD6B55',
            confirmButtonText: 'Delete',
            closeOnConfirm: true
        }, function(){
            var container = $(that).closest('.list-group-item');

            container.addClass('flipOutX');
            setTimeout(function(){
                container.remove();
            }, 1000);
        });
    });
});