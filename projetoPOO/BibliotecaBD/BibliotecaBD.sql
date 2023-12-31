PGDMP                         {            poo    14.5    14.5 "               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    17016    poo    DATABASE     c   CREATE DATABASE poo WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE poo;
                postgres    false            �            1259    17123    cliente    TABLE     �   CREATE TABLE public.cliente (
    idcliente integer NOT NULL,
    nomecliente character varying(50),
    cpfcliente character varying(14)
);
    DROP TABLE public.cliente;
       public         heap    postgres    false            �            1259    17122    cliente_idcliente_seq    SEQUENCE     �   CREATE SEQUENCE public.cliente_idcliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.cliente_idcliente_seq;
       public          postgres    false    212                       0    0    cliente_idcliente_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.cliente_idcliente_seq OWNED BY public.cliente.idcliente;
          public          postgres    false    211            �            1259    17180    livro    TABLE     �   CREATE TABLE public.livro (
    idlivro integer NOT NULL,
    nomelivro character varying(50),
    genero character varying(50),
    reservado boolean DEFAULT false
);
    DROP TABLE public.livro;
       public         heap    postgres    false            �            1259    17179    livro_id_seq    SEQUENCE     �   CREATE SEQUENCE public.livro_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.livro_id_seq;
       public          postgres    false    214                       0    0    livro_id_seq    SEQUENCE OWNED BY     B   ALTER SEQUENCE public.livro_id_seq OWNED BY public.livro.idlivro;
          public          postgres    false    213            �            1259    17243    reserva_livro    TABLE     r   CREATE TABLE public.reserva_livro (
    idreserva integer NOT NULL,
    clienteid integer,
    livroid integer
);
 !   DROP TABLE public.reserva_livro;
       public         heap    postgres    false            �            1259    17242    reserva_livro_id_seq    SEQUENCE     �   CREATE SEQUENCE public.reserva_livro_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.reserva_livro_id_seq;
       public          postgres    false    216                       0    0    reserva_livro_id_seq    SEQUENCE OWNED BY     T   ALTER SEQUENCE public.reserva_livro_id_seq OWNED BY public.reserva_livro.idreserva;
          public          postgres    false    215            �            1259    17116    usuario    TABLE     �   CREATE TABLE public.usuario (
    idusuario integer NOT NULL,
    nomeusuario character varying(50),
    cpfusuario character varying(14),
    login character varying(50),
    senha character varying(50)
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �            1259    17115    usuario_id_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.usuario_id_seq;
       public          postgres    false    210                       0    0    usuario_id_seq    SEQUENCE OWNED BY     H   ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.idusuario;
          public          postgres    false    209            l           2604    17126    cliente idcliente    DEFAULT     v   ALTER TABLE ONLY public.cliente ALTER COLUMN idcliente SET DEFAULT nextval('public.cliente_idcliente_seq'::regclass);
 @   ALTER TABLE public.cliente ALTER COLUMN idcliente DROP DEFAULT;
       public          postgres    false    211    212    212            m           2604    17183    livro idlivro    DEFAULT     i   ALTER TABLE ONLY public.livro ALTER COLUMN idlivro SET DEFAULT nextval('public.livro_id_seq'::regclass);
 <   ALTER TABLE public.livro ALTER COLUMN idlivro DROP DEFAULT;
       public          postgres    false    214    213    214            o           2604    17246    reserva_livro idreserva    DEFAULT     {   ALTER TABLE ONLY public.reserva_livro ALTER COLUMN idreserva SET DEFAULT nextval('public.reserva_livro_id_seq'::regclass);
 F   ALTER TABLE public.reserva_livro ALTER COLUMN idreserva DROP DEFAULT;
       public          postgres    false    216    215    216            k           2604    17119    usuario idusuario    DEFAULT     o   ALTER TABLE ONLY public.usuario ALTER COLUMN idusuario SET DEFAULT nextval('public.usuario_id_seq'::regclass);
 @   ALTER TABLE public.usuario ALTER COLUMN idusuario DROP DEFAULT;
       public          postgres    false    210    209    210                      0    17123    cliente 
   TABLE DATA           E   COPY public.cliente (idcliente, nomecliente, cpfcliente) FROM stdin;
    public          postgres    false    212   �$       
          0    17180    livro 
   TABLE DATA           F   COPY public.livro (idlivro, nomelivro, genero, reservado) FROM stdin;
    public          postgres    false    214   2%                 0    17243    reserva_livro 
   TABLE DATA           F   COPY public.reserva_livro (idreserva, clienteid, livroid) FROM stdin;
    public          postgres    false    216   �%                 0    17116    usuario 
   TABLE DATA           S   COPY public.usuario (idusuario, nomeusuario, cpfusuario, login, senha) FROM stdin;
    public          postgres    false    210   �%                  0    0    cliente_idcliente_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.cliente_idcliente_seq', 4, true);
          public          postgres    false    211                       0    0    livro_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.livro_id_seq', 4, true);
          public          postgres    false    213                       0    0    reserva_livro_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.reserva_livro_id_seq', 4, true);
          public          postgres    false    215                       0    0    usuario_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.usuario_id_seq', 10, true);
          public          postgres    false    209            s           2606    17128    cliente cliente_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (idcliente);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    212            u           2606    17186    livro livro_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.livro
    ADD CONSTRAINT livro_pkey PRIMARY KEY (idlivro);
 :   ALTER TABLE ONLY public.livro DROP CONSTRAINT livro_pkey;
       public            postgres    false    214            w           2606    17248     reserva_livro reserva_livro_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.reserva_livro
    ADD CONSTRAINT reserva_livro_pkey PRIMARY KEY (idreserva);
 J   ALTER TABLE ONLY public.reserva_livro DROP CONSTRAINT reserva_livro_pkey;
       public            postgres    false    216            q           2606    17121    usuario usuario_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (idusuario);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    210            x           2606    17249 *   reserva_livro reserva_livro_clienteid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.reserva_livro
    ADD CONSTRAINT reserva_livro_clienteid_fkey FOREIGN KEY (clienteid) REFERENCES public.cliente(idcliente);
 T   ALTER TABLE ONLY public.reserva_livro DROP CONSTRAINT reserva_livro_clienteid_fkey;
       public          postgres    false    216    3187    212            y           2606    17254 (   reserva_livro reserva_livro_livroid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.reserva_livro
    ADD CONSTRAINT reserva_livro_livroid_fkey FOREIGN KEY (livroid) REFERENCES public.livro(idlivro);
 R   ALTER TABLE ONLY public.reserva_livro DROP CONSTRAINT reserva_livro_livroid_fkey;
       public          postgres    false    216    3189    214               ?   x�3�t�L�KN�444�322�366�31�2�t,*�(-B75�2���Ȯ�����T��qqq ���      
   B   x�3����M�Up,J��H�tLN��,�2����rS��a�F���᜾�%�9�陉@�=... í�            x�3�4�4�2�B.NN#�=... "B�         �   x�3�N�-M�Qp�L,�400�344�322�56�Jq�p���d��f%r�B1B��X�)�1�Sfb^r"�`��1͌ӱ�$��H!(?�(3�4��*
Qc�l��PqC�2���aA�-�=�0��b���*8��7Z����R�V��	������ z�R�     