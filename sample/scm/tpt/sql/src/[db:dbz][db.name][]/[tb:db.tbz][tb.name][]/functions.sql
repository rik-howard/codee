.             |
.             | delimiter @@@
.             |
.[uk:tb.ukz]  | create function [db.name].[tb.name]_id_by[pt:uk.ptz]_[pt.name][]
.             | (
.[pt:uk.ptz]  |   [pt.name]_in [pt.type][:exists:pt.length] ([pt.length][:exists:pt.precision], [pt.precision][])[][:isLast:pt][:],[]
.[]           | )
.             | returns integer ([tb.idLength])
.             | begin
.             |   set @id = 0;
.             |   select id
.             |   into @id
.             |   from [db.name].[tb.name]
.[pt:uk.ptz]  |   [:isFirst:pt]where[:]and[] [pt.name] = [pt.name]_in[:isLast:pt];[]
.[]           |   return @id;
.             | end;
.             | @@@
.             |
.[][fk:tb.fkz]| create function [db.name].[tb.name]_[fk.name]_id (id_in integer ([tb.idLength]))
.             | returns integer ([fk.length])
.             | begin
.             |   set @[fk.name]_id = 0;
.             |   select [fk.name]_id
.             |   into @[fk.name]_id
.             |   from [db.name].[tb.name]
.             |   where id = id_in;
.             |   return @[fk.name]_id;
.             | end;
.             | @@@
.             |
.[][nk:tb.nkz]| create function [db.name].[tb.name]_[nk.name] (id_in integer ([tb.idLength]))
.             | returns [nk.type] [:exists:nk.length]([nk.length][:exists:nk.precision], [nk.precision][])[]
.             | begin
.             |   set @[nk.name] = 0;
.             |   select [nk.name]
.             |   into @[nk.name]
.             |   from [db.name].[tb.name]
.             |   where id = id_in;
.             |   return @[nk.name];
.             | end;
.             | @@@
.             |
.[]           | create function [db.name].[tb.name]_insertion
.             | (
.[fd:tb.fdz]  |   [fd.name]_in [fd.type][:exists:fd.length] ([fd.length][:exists:fd.precision], [fd.precision][])[][:isLast:fd][:],[]
.[]           | )
.             | returns integer ([tb.idLength])
.             | begin
.             |   set @id = 0;
.             |   call [db.name].[tb.name]_insert
.             |   (
.[fd:tb.fdz]  |     [fd.name]_in[:isLast:fd][:],[]
.[]           |   );
.             |   select last_insert_id()
.             |   into @id;
.             |   return @id;
.             | end;
.             | @@@
.             |
.             | delimiter ;
.             |
