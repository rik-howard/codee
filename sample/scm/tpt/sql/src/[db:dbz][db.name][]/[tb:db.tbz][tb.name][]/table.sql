.             |
.             | create table [db.name].[tb.name]
.             | (
.             |   id integer ([tb.idLength]) unsigned zerofill not null auto_increment,
.[fk:tb.fkz]  |   [fk.name]_id integer ([fk.length]) unsigned zerofill not null,
.[][nk:tb.nkz]|   [nk.name] [nk.type] [:exists:nk.length]([nk.length][:exists:nk.precision], [nk.precision][]) [][:exists:nk.nullNeg]not []null,
.[]           |   primary key (id),
.[fk:tb.fkz]  |   foreign key ([fk.name]_id) references [fk.refDb].[fk.refTb] (id),
.[][uk:tb.ukz]|   unique ([pt:uk.ptz][pt.name][:isLast:pt][:], [][])[:isLast:uk][:],[]
.[]           | ) type = [tb.type];
.             |
