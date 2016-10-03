insert into game_rolls 
select * from CSVREAD('classpath:db/games.csv'
	,'id
	,first_roll
	,second_roll
	,third_roll
	,fourth_roll
	,fifth_roll
	,sixth_roll
	,seventh_roll
	,eighth_roll
	,ninth_roll
	,tenth_roll
	,eleventh_roll
	,twelfth_roll
	,thirteenth_roll
	,fourteenth_roll
	,fifteenth_roll
	,sixteenth_roll
	,seventeenth_roll
	,eighteenth_roll
	,nineteenth_roll
	,twentyth_roll
	,twenty_first_roll
');
