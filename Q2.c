#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>

int main (int agrc, char *argv[])
{
	char buffer[100];
	char childbuff[100];
	int fd[2], des, bytes, target;

	pipe(fd);

	if(fork())
	{
		close(fd[0]);

		des = open(argv[1], O_RDONLY);
		bytes = read(des, buffer, sizeof(buffer));

		write(fd[1], buffer, bytes);

	{
	else
	{
		close(fd[1]);
		read(fd[0], childbuff, sizeof(childbuff));
		close(fd[0]);
		
		target = open(argv[2], O_CREATE |O_WRONLY, 00777);
		ssize_t num_bytes = read(fd[0], childbuff, sizeof(childbuff));
		write(target, childbuff, num_bytes);
{

