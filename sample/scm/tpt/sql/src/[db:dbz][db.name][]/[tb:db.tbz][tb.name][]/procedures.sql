.             |
.             | delimiter @@@
.             |
.             | create procedure [db.name].[tb.name]_insert
.             | (
.[fd:tb.fdz]  |   [fd.name]_in [fd.type][:exists:fd.length] ([fd.length][:exists:fd.precision], [fd.precision][])[][:isLast:fd][:],[]
.[]           | )
.             | insert into [db.name].[tb.name]
.             | (
.[fd:tb.fdz]  |   [fd.name][:isLast:fd][:],[]
.[]           | )
.             | values
.             | (
.[fd:tb.fdz]  |   [fd.name]_in[:isLast:fd][:],[]
.[]           | );
.             | @@@
.             |
.             | create procedure [db.name].[tb.name]_update
.             | (
.             |   id_in integer ([tb.idLength]),
.[fd:tb.fdz]  |   [fd.name]_in [fd.type][:exists:fd.length] ([fd.length][:exists:fd.precision], [fd.precision][])[][:isLast:fd][:],[]
.[]           | )
.             | update [db.name].[tb.name]
.             | set
.[fd:tb.fdz]  |   [fd.name] = [fd.name]_in[:isLast:fd][:],[]
.[]           | where id = id_in;
.             | @@@
.             |
.             | create procedure [db.name].[tb.name]_delete
.             | (
.             |   id_in integer ([tb.idLength])
.             | )
.             | delete from [db.name].[tb.name]
.             | where id = id_in;
.             | @@@
.             |
.             | delimiter ;
.             |
